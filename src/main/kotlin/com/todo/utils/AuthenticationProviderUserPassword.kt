package com.todo.utils

import com.todo.repository.UsersRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink

@Singleton
class AuthenticationProviderUserPassword(private val usersRepository : UsersRepository) : AuthenticationProvider {

    override fun authenticate(httpRequest: HttpRequest<*>?,
                              authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {

        val user = usersRepository.findByUserName(authenticationRequest.identity.toString())
        val requestPassword = UserPasswordHashingSha256.hashPassword(authenticationRequest.secret.toString())
        val map = mutableMapOf<String, Any>()
        map["user_id"] = user.id
        map["user_role"] = user.roleId

        return Flux.create({ emitter: FluxSink<AuthenticationResponse> ->
            if (authenticationRequest.identity == user.userName && requestPassword == user.password) {
                emitter.next(AuthenticationResponse.success(authenticationRequest.identity as String, map))
                emitter.complete()
            } else {
                emitter.error(AuthenticationResponse.exception())
            }
        }, FluxSink.OverflowStrategy.ERROR)
    }
}
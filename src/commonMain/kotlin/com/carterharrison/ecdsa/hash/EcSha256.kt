package com.carterharrison.ecdsa.hash

import com.soywiz.krypto.SHA256

object EcSha256 : EcHasher {
    override fun hash(data: ByteArray): ByteArray {
        return SHA256.digest(data).bytes
    }
}
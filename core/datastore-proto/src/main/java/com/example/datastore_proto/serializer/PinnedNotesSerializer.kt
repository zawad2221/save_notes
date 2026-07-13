package com.example.datastore_proto.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.datastore_proto.PinnedNotesProto
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object PinnedNotesSerializer : Serializer<PinnedNotesProto> {
    override val defaultValue: PinnedNotesProto = PinnedNotesProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): PinnedNotesProto {
        try {
            return PinnedNotesProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: PinnedNotesProto, output: OutputStream) = t.writeTo(output)
}
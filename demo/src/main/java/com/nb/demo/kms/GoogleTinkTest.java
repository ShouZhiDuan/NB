package com.nb.demo.kms;

import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleTinkTest {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        AeadConfig.register();
        // Generate the key material...
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                KeyTemplates.get("AES128_GCM"));
        // and write it to a file.
        String keysetFilename = "my_keyset.json";
        CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(
                new File(keysetFilename)));
    }
}
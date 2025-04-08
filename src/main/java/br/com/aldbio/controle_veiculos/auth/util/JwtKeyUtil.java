package br.com.aldbio.controle_veiculos.auth.util;

import javax.crypto.SecretKey;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtKeyUtil {
	
	 private static final String SECRET = "CtSfVVEJopG5OfZ+kRBzoKQqncWYYm7upT0eDyr56H0="; // Must be 32 bytes

	    public static SecretKey getSecretKey() {
	        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
	    }

}

package kz.dostyk.sportsclub.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // 🔐 СЕКРЕТНЫЙ КЛЮЧ (НЕ МЕНЯЙ, ПОКА УЧИМСЯ)
    private static final String SECRET_KEY =
            "myverystrongsecretkeymyverystrongsecretkey";

    // ⏱️ ВРЕМЯ ЖИЗНИ ТОКЕНА (1 час)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    // 🔑 Получаем ключ
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(
                java.util.Base64.getEncoder().encodeToString(SECRET_KEY.getBytes())
        );
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 🎫 Генерация токена
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 📤 Получить username из токена
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ⏳ Проверка: истёк ли токен
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // ✅ Валидность токена
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // 🧠 Вытаскиваем всё из токена
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

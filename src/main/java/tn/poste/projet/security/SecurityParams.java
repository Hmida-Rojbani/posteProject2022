package tn.poste.projet.security;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="poste2022";
    public static final long EXPIRATION=3600;
    public static final String HEADER_PREFIX="Bearer ";
}
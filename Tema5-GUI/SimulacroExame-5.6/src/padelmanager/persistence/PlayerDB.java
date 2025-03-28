package padelmanager.persistence;

import padelmanager.model.Player;

/**
 * Inclue o metodo para acceder aos xogadores da aplicación
 *
 * @author Xaquin Alves González
 */
public class PlayerDB {

    /**
     * Busca a un xogador por id e contrasinal
     *
     * @param playerId identificador do xogador
     * @param password contrasinal do xogador
     * @return xogador se se atopa, se non null
     */
    public static Player findByIdAndPassword(String playerId, String password) {
        if (PadelManagerDB.getPlayers().containsKey(playerId)) {
            if(PadelManagerDB.getPlayers().get(playerId).getPassword().equals(password)){
                return PadelManagerDB.getPlayers().get(playerId);
            }
        } 
        return null;
    }
}

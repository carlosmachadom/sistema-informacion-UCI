/**
 *
 */
package co.edu.unbosque.controller;

/**
 *
 */
//TODO documentacion
import co.edu.unbosque.model.user.Users;
import co.edu.unbosque.model.persistence.DAO.UsersDAO;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.persistence.LogIn;

import java.awt.event.ActionEvent;

/**
 *
 */
import java.awt.event.ActionListener;

/**
 *
 */
public class UCI implements ActionListener {
    private LogIn logIn;
    private UserDTO userDTO;
    private Users users;

    public UCI() {
        logIn = new LogIn();
        userDTO = new UserDTO();
        users = new Users();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

    }

}

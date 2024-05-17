package co.edu.unbosque.model.cyclists;

/**
 * Esta clase representa a un ciclista gregario, heredando las características de la clase `Cyclist`.
 * Un ciclista gregario se especializa en trabajar en equipo para ayudar a otros ciclistas en el pelotón.
 */
public class Gregarious extends Cyclist {
    /**
     * Función del ciclista dentro del pelotón (por ejemplo, lanzador, protector).
     */
    private String functionPlatoon;

    /**
     * Constructor de la clase `Gregarious`.
     *
     * @param name            Nombre del ciclista.
     * @param bodyStructure   Contextura física del ciclista.
     * @param cadencePedaling Cadencia de pedaleo del ciclista.
     * @param CC              Cédula de identidad del ciclista.
     * @param experience      Años de experiencia del ciclista.
     * @param email           Correo electrónico del ciclista.
     * @param password        Contraseña del ciclista.
     */
    public Gregarious(String name,
                      String bodyStructure,
                      String cadencePedaling,
                      long CC,
                      int experience,
                      String email,
                      String password) {
        super(name, bodyStructure, cadencePedaling, CC, experience, email, password);
    }

    /**
     * Este método abstracto se hereda de la clase `Cyclist` y debe ser implementado para definir la especialidad del ciclista gregario.
     * En este caso, la implementación podría detallar cómo el ciclista apoya a sus compañeros en el pelotón.
     */
    @Override
    public void specialty() {

    }
}

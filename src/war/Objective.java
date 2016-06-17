package war;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diegomachado
 */
public class Objective {

    private static Objective instance;
    private static final Map<Integer, String> objectives;

    static {
        objectives = new HashMap<>();

        objectives.put(1, "Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro.");
        objectives.put(2, "Conquistar na totalidade a ASIA e a AMÉRICA DO SUL.");
        objectives.put(3, "Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro.");
        objectives.put(4, "Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos.");
        objectives.put(5, "Conquistar na totalidade a ASIA e a ÁFRICA.");
        objectives.put(6, "Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA.");
        objectives.put(7, "Conquistar 24 TERRITÓRIOS à sua escolha.");
        objectives.put(8, "Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA.");
        objectives.put(9, "Destruir totalmente OS EXÉRCITOS AZUIS ou conquistar 18 territórios caso ele não esteja em jogo.");
        objectives.put(10, "Destruir totalmente OS EXÉRCITOS AMARELOS ou conquistar 18 territórios caso ele não esteja em jogo.");
        objectives.put(11, "Destruir totalmente OS EXÉRCITOS VERMELHOS ou conquistar 18 territórios caso ele não esteja em jogo.");
        objectives.put(12, "Destruir totalmente OS EXÉRCITOS PRETOS ou conquistar 18 territórios caso ele não esteja em jogo.");
        objectives.put(13, "Destruir totalmente OS EXÉRCITOS BRANCO ou conquistar 18 territórios caso ele não esteja em jogo.");
        objectives.put(14, "Destruir totalmente OS EXÉRCITOS VERDES ou conquistar 18 territórios caso ele não esteja em jogo.");
    }

    public static String getObjective() {
        return objectives.get((int) (1 + Math.random() * 14));
    }
    
    public static Objective getInstance() {
        if (instance == null){
            initializeInstance();
        }
        return instance;
    }

    private static synchronized void initializeInstance() {
        if (instance == null) {
            instance = new Objective();
        }
    }
}

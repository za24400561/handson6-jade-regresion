import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class PRAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new PRBehaviour());
    }

    private class PRBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            DataSet ds = new DataSet();
            PolynomialRegression pr = new PolynomialRegression(ds.getX(), ds.getY(), 2);
            System.out.println("[" + myAgent.getLocalName() + "] Ecuación: " + pr.getEquation());

            double[] xs = {50.0, 100.0, 150.0};
            for (double x : xs)
                System.out.printf("[%s] y = %.4f + %.4f*(%.1f) + %.4f*(%.1f)^2 = %.4f%n",
                        myAgent.getLocalName(), pr.getBeta0(), pr.getBeta1(), x,
                        pr.getBeta2(), x, pr.predict(x));

            System.out.printf("[%s] R^2 = %.4f%n", myAgent.getLocalName(), pr.calculateRSquared());
            myAgent.doDelete();
        }
    }

    @Override
    protected void takeDown() {
        System.out.println("[" + getLocalName() + "] Agente finalizado.");
    }
}

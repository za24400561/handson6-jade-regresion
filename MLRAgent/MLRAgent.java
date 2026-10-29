import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class MLRAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new MLRBehaviour());
    }

    private class MLRBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            DataSet ds = new DataSet();
            MultipleLinearRegression mlr = new MultipleLinearRegression(ds.getXMultiple(), ds.getY());
            System.out.println("[" + myAgent.getLocalName() + "] Ecuación: " + mlr.getEquation()
                    + "   (x1=TV, x2=Radio, x3=Newspaper)");

            double[][] casos = {{100, 20, 30}, {200, 40, 60}, {50, 10, 5}};
            for (double[] c : casos)
                System.out.printf("[%s] TV=%.0f, Radio=%.0f, Newspaper=%.0f -> Sales = %.4f%n",
                        myAgent.getLocalName(), c[0], c[1], c[2], mlr.predict(c));

            System.out.printf("[%s] R^2 = %.4f%n", myAgent.getLocalName(), mlr.calculateRSquared());
            myAgent.doDelete();
        }
    }

    @Override
    protected void takeDown() {
        System.out.println("[" + getLocalName() + "] Agente finalizado.");
    }
}

/** y = b0 + b1 x1 + ... + bk xk */
public class MultipleLinearRegression extends LeastSquaresRegressor {
    private final int k;
    public MultipleLinearRegression(double[][] x, double[] y) {
        this.k = x[0].length;
        double[][] d = new double[x.length][k + 1];
        for (int i = 0; i < x.length; i++) {
            d[i][0] = 1;
            System.arraycopy(x[i], 0, d[i], 1, k);
        }
        fit(d, y);
    }
    public double predict(double... xs) {
        double[] r = new double[k + 1];
        r[0] = 1;
        System.arraycopy(xs, 0, r, 1, k);
        return predictRow(r);
    }
    @Override public String getEquation() {
        StringBuilder sb = new StringBuilder(String.format("y = %.4f", betas[0]));
        for (int i = 1; i <= k; i++)
            sb.append(String.format(" %s %.4f x%d", betas[i] < 0 ? "-" : "+", Math.abs(betas[i]), i));
        return sb.append("  - MLR").toString();
    }
}

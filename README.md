# Hands-on 6 – Agent-based Simulation (JADE)

Agentes JADE con un solo OneShotBehaviour que calculan regresiones por mínimos cuadrados:

- **SLRAgent**: Regresión Lineal Simple
- **PRAgent**: Regresión Polinomial
- **MLRAgent**: Regresión Lineal Múltiple

Cada carpeta es autocontenida. Para compilar y ejecutar, entra a la carpeta del agente:

    javac -cp jade.jar *.java
    java -cp jade.jar:. jade.Boot -agents slr:SLRAgent

En Windows, el separador del classpath es `;` en lugar de `:`.
Para PRAgent y MLRAgent cambia el nombre en el último comando (`pr:PRAgent`, `mlr:MLRAgent`).

# PO_2019-2020
### Object-Oriented Programming 2019/2020
##### Catarina Sousa e Nelson Trindade, IST-TagusPark

## UML
Program used to make UML: **NClass**

* [PDF](UML/Projeto%20PO.pdf)

Grade: *2,60* / 3,0

## Project (Java)

* [Project](Project/docs/document.pdf)
* [Files](Project/m19)

Grade: *5,65* / 6,0 + *10,18* / 11,0

Total Grade = **18,43**

---

## Compilação do Projecto

O projecto pode ser compilado de duas formas. Assumindo que se está no directório que inclui o directório sth (que é o directório raiz que contém o código da aplicação a desenvolver), a compilação pode ser feita das seguintes formas:

```bash
javac -cp po-uilib.jar:. `find m19 -name *.java`
find m19 -name "*.java" -print | xargs javac -cp po-uilib.jar:.
```

onde po-uilib.jar é o ficheiro jar com o código da framework de interação com o utilizador e está-se a assumir que também estão no mesmo directório que inclui o directório . Casos os ficheiros tenham outro nome, ou estejam noutro directório então é necessário alterar o comando por forma a ter em conta as alterações.

## Execução do Projecto

Assumindo que se está ainda no mesmo directório que inclui o directório sth, para executar o projecto é necessário dar o seguinte comando:

```bash
java -cp po-uilib.jar:. m19.app.App
```

Se se quiser começar a aplicação indicando um ficheiro com o estado inicial da aplicação (por exemplo, ficheiro.im), então é necessário dar o seguinte comando:

```bash
java -Dimport=ficheiro.im -cp po-uilib.jar:. m19.app.App
```

A opção -Dchave=valor do executável java permite a definição de propriedades no momento de execução de um programa Java. Uma propriedade tem uma chave e um valor e é possível saber qual é o valor de uma determinada propriedade em tempo de execução. Para isso, deve-se utilizar o método System.getProperty, indicando como argumento o nome (ou chave) da propriedade. Este método devolve o valor associado à propriedade indicada. Caso não haja nenhuma propriedade definida com a chave indicada, o méetodo retornará null.

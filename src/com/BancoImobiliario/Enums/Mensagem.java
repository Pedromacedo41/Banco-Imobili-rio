package com.BancoImobiliario.Enums;

public enum Mensagem {

    M1("Você tirou o primeiro lugar no torneio de Tênis do seu Clube. Parabéns!",false, 100),
    M2("O seu cachorro policial tirou o 1° prêmio na exposição do Kennel Club", false, 100),
    M3("Você foi promovido a diretor de sua empresa", false, 100),
    M4("Você está com sorte. Suas ações na Bolsa de Valores estão em alta", false, 200),
    M5("Você apostou com os parceiros deste jogo e ganhou", false, 50),
    M6("Você trocou seu carro usado com um amigo e ainda saiu lucrando", false, 50),
    M7("Houve um assalto à sua loja, mas você estava segurado", false, 150),
    M8("Você acaba de receber uma parcela do seu 13° salário",false, 50),
    M9("Avance até o ponto de partida e .. ganhe 200", false, 200),
    M10("Inesperadamente você recebeu uma herança que já estava esquecida",false, 100),
    M11("Você saiu de férias e se hospedou na casa de um amigo. Você economizou o hotel",false, 45),
    M12("Um amigo tinha lhe pedido um empréstimo e se esqueceu de devolver. Ele acaba de se lembrar", false,80),
    M13("Você jogou na Loteria Esportiva com um grupo de amigos. Ganharam!", false, 20),
    M14("A prefeitura mandou abrir uma nova avenida, para o que desapropriou vários prédios. Em consequência seu terreno valorizou", false, 25),
    M15("Você estacionou seu carro em lugar proibido e entrou na contra mão", true, 30),
    M16("Um amigo pediu-lhe um empréstimo. Você nao pode recusar",true, 15),
    M17("Você é papai outra vez. Despesas de maternidade", true, 100),
    M18("Vá para a prisão sem receber nada. (Talvez eu lhe faça uma visita...)", true, 0),
    M19("Papai os livros do ano passado não servem mais, preciso de livros novos", true, 40),
    M20("Seus parentes do interior vieram passar umas 'férias' na sua casa", true, 45),
    M21("Você achou interessante assistir à estréia da temporada de ballet. Compre os ingressos",true, 30),
    M22("Parabéns! Você convidou seus amigos para festejar o aniversário.", true, 100),
    M23("Você acaba de receber a comunicação do Imposto de Renda", true, 50),
    M24("Você vai casar e está comprando um apartamento novo", true, 25),
    M25("Seu clube está ampliando as piscinas. Os sócios devem contribuir", true, 25),
    M26("Renove a tempo a licença do seu automóvel", true, 30),
    M27("O médico lhe recomendou repouso num bom hotel de montanha", true, 45),
    M28("A geada prejudicou a sua safra de café", true, 50),
    M29("Seus filhos já vão para a escola. Pague a primeira mensalidade", true, 50);

    private String mensagem;
    private boolean reves;
    private int valor;

    Mensagem(String mensagem, boolean reves, int valor) {
        this.mensagem = mensagem;
        this.reves = reves;
        this.valor = valor;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isReves() {
        return reves;
    }

    public int getValor() {
        return valor;
    }
}

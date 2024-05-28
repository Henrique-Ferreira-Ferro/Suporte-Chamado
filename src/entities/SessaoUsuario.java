package entities;

public class SessaoUsuario {
	
	/*
	 * Classe para salvar uma sessão.
	 * Preciso associar o id da pessoa que entrou 
	 * com a pessoa que cadastrou a senha, além e 
	 * claro da pessoa que está abrindo um chamado. Se 
	 * a pessoa não tiver selecionado ninguem
	 */
	
	
	private static SessaoUsuario instancia;
    private int idUsuario;

    private SessaoUsuario() { }

    /*
     * Gera instancia da clase se estiver vaziu
     */
    public static SessaoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}


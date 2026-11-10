package models;

public class TextFile {
    // Atributos privados
    private String name;
    private String content;
    private int size;
    
    // Construtor 1: Cria um arquivo vazio apenas com o nome
    public TextFile(String name) throws Exception {
        this.name = checkName(name); // Valida e limpa o nome recebido
        this.content = "";           // Inicializa vazio
        this.size = calculeSize();   // Tamanho inicial será 0
    }

    // Construtor 2: Cria um arquivo já com nome e conteúdo
    public TextFile(String name, String content) throws Exception {
        this.name = checkName(name);
        this.content = content != null ? content : "";
        this.size = calculeSize();
    }

    // Métodos

    // Atualiza o conteúdo do arquivo e recalcula seu tamanho
    public void edit(String content){
        this.content = content != null ? content : "";
        this.size = calculeSize();
    }

    // Limpa o conteúdo do arquivo e zera seu tamanho
    public void clear(){
        this.content = "";
        this.size = calculeSize(); // Será 0
    }

    // Tenta renomear o arquivo validando o novo nome
    public void rename(String name) throws Exception {
        this.name = checkName(name); 
    }

    // Validação principal do nome do arquivo
    private String checkName(String name) throws Exception {
        // Verifica nulo
        if (name == null) {
            throw new Exception("O nome do arquivo não pode ser nulo.");
        }
        
        // Remove espaços do início e fim
        String sanitizedName = name.trim();
        
        // Verifica se ficou vazio
        if (sanitizedName.isEmpty()) {
            throw new Exception("O nome do arquivo não pode estar em branco.");
        }
        
        // Remove caracteres especiais (mantém apenas letras de a-z, A-Z e números)
        sanitizedName = sanitizedName.replaceAll("[^a-zA-Z0-9]", "");
        
        // Verificação de segurança adicional pós-limpeza (ex: se o usuário digitou só "@#$")
        if (sanitizedName.isEmpty()) {
            throw new Exception("O nome do arquivo não contém caracteres válidos.");
        }
        
        return sanitizedName;
    }

    // Calcula o tamanho (1 caractere = 1 byte)
    private int calculeSize(){
        if (this.content == null) {
            return 0;
        }
        return this.content.length(); // O tamanho da string equivale à quantidade de caracteres (bytes)
    }

    // Getters (inalterados)
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    // toString() - Retorna os campos name e size formatados
    @Override
    public String toString() {
        return "Arquivo: " + this.name + " | Tamanho: " + this.size + " bytes";
    }
}
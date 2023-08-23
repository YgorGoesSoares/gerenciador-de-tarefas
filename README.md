# Gerenciador de Tarefas

Bem-vindo ao **Gerenciador de Tarefas**! Este é um aplicativo para organizar suas tarefas pendentes. Com ele, você pode adicionar, marcar como concluídas e excluir tarefas de maneira eficiente.

## Tecnologias Utilizadas

- **Linguagens**: HTML, CSS, Java (Spring Boot), Thymeleaf (template engine)
- **Frontend Framework**: Bootstrap
- **Bibliotecas JavaScript**: jQuery, Popper.js
- **Dependências do Spring Boot**: Spring Web, Spring Data JPA, H2 Database (embutido para desenvolvimento)
- **Build Tool**: Maven
- **Versionamento de Código**: Git

## Como Executar

1. Clone o repositório para a sua máquina local:

   \`\`\`
   git clone https://github.com/YgorGoesSoares/gerenciador-de-tarefas.git
   \`\`\`

2. Navegue para o diretório do projeto:

   \`\`\`
   cd br.com.ygor.gerenciador
   \`\`\`

3. Execute o aplicativo usando o Maven:

   \`\`\`
   mvn spring-boot:run
   \`\`\`

4. Abra o navegador e acesse [http://localhost:8080](http://localhost:8080) para visualizar o aplicativo.

## Funcionalidades

- **Adicionar Tarefa**: Insira uma nova tarefa na lista de tarefas pendentes.
- **Concluir Tarefa**: Marque uma tarefa como concluída.
- **Excluir Tarefa**: Remova uma tarefa da lista.

## Estrutura do Projeto

- O diretório \`src/main/java\` contém o código Java, incluindo os controladores e a lógica do aplicativo.
- O diretório \`src/main/resources\` contém os arquivos de configuração e os templates Thymeleaf.

  ![Caso de Uso e Diagrama de Classe do projeto](gerenciador-de-tarefas/diagrams/diagram_gerenciador_tarefas.png)

## Contribuição

Se você quiser contribuir para o desenvolvimento deste aplicativo, siga estas etapas:

1. Faça um fork deste repositório.
2. Crie um novo branch para a sua contribuição:

   \`\`\`
   git checkout -b minha-contribuicao
   \`\`\`

3. Faça as alterações necessárias e faça commit das mudanças:

   \`\`\`
   git commit -m "Minha contribuição"
   \`\`\`

4. Envie as alterações para o seu fork:

   \`\`\`
   git push origin minha-contribuicao
   \`\`\`

5. Abra um pull request para este repositório principal.

Feito com ❤️ por Ygor Goes | [https://www.linkedin.com/in/ygor-goes-8649b9193/]

# Huffman Compressor

Implementação de um compressor e descompressor sem perdas baseado no algoritmo de Huffman, desenvolvido em Java sem dependências externas.

---

## 📋 Progresso

- [x] Marco 0: Manipulação de bits em baixo nível
- [x] Marco 1: Leitura de arquivos e contagem de frequências
- [x] Marco 2: Construção da árvore com fila de prioridade
- [ ] Marco 3: Geração da tabela de códigos binários
- [ ] Marco 4: Codificação e decodificação em memória
- [ ] Marco 5: Streams de I/O a nível de bit (`BitWriter` / `BitReader`)
- [ ] Marco 6: Formato do arquivo comprimido e descompressão completa
- [ ] Marco 7: Tratamento de casos de borda e interface CLI

---

## 🧠 Decisões Técnicas

- **Tratamento de bytes sem sinal (`b & 0xFF`):** Em Java, o tipo primitivo `byte` é assinado (valores de `-128` a `127`). Para tratar o fluxo de dados como valores binários puros de `0` a `255` e permitir indexação direta no array de contagem, todas as leituras aplicam a máscara `& 0xFF`.
- **Tabela de frequência em array fixo (`int[256]`):** O espaço de amostragem de qualquer byte é exatamente 256 combinações possíveis. Utilizar um array de tamanho fixo garante acesso $O(1)$, cache locality e alocação mínima de memória frente a mapas genéricos.
- **Desempate determinístico na árvore (`orderCreated`):** Quando dois nós na `PriorityQueue` possuem a mesma frequência, a ordem de desempate precisa ser estritamente reproduzível. Sem isso, a árvore montada durante a descompressão poderia ter ramificações invertidas em relação à da compressão, corrompendo os dados. A atribuição de um índice sequencial garante um critério de desempate estável.
- **Zero dependências externas:** O projeto utiliza estritamente recursos padrão do JDK (`java.io`, `java.nio.file`, `java.util`), mantendo o código autocontido e com foco em algoritmos fundamentais.

---

## 🚀 Como Executar

### Compilação
```bash
javac -d out/production/Compressor src/Main.java src/milestones/*.java
```

### Execução
```bash
java -cp out/production/Compressor Main <caminho-do-arquivo>
```

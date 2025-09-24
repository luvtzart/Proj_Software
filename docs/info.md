# Contexto
Uma cooperativa rural deseja monitorar plantações usando drones que realizam sobrevoos periódicos para coletar imagens e dados ambientais (temperatura, umidade e pragas).

*Funcionalidades mínimas a implementar*
Cadastro de áreas agrícolas (tamanho, localização e tipo de cultivo).
Cadastro de drones (ID, sensores disponíveis e status).
Agendamento de missões de voo (data, área e sensores a utilizar)
Registro de dados coletados (imagens e valores de sensores simulados).
Relatórios básicos sobre condições da plantação (últimas medições e voos realizados).

*Requisitos de segurança*
Controle de acesso diferenciado (administrador e operador de drone).
Validação para impedir missões sobrepostas no mesmo drone.
Tratamento seguro de dados de sensores (evitar entradas inválidas ou corrompidas).
Checklist de segurança antes do voo (bateria mínima e sensores funcionando).

# Precisa conter:
Modelagem inicial: elaborar diagramas de classes e sequência, respeitando boas práticas de encapsulamento e validação de dados.
Integração dos modelos: consolidar classes, interações, estados e colaboração, prevendo restrições de segurança.
Implementação: transformar os modelos em código Java, aplicando programação segura (validação de entradas, tratamento de exceções e uso de prepared statements).
Controle de versão: utilizar GitHub desde a primeira entrega, com commits organizados, e sem credenciais ou dados sensíveis no repositório.
Documentação e apresentação: gerar documentação clara, checklist de segurança e vídeo explicativo demonstrando o sistema.

# Criterios de Segurança:
Encapsulamento adequado (atributos privados).
Validação de dados em todos os fluxos.
Prevenção de injeções (SQL Injection e dados maliciosos).
Tratamento de exceções sem expor informações internas.
Uso correto do GitHub (sem senhas e códigos sensíveis).
Checklist de segurança revisado antes da entrega final.

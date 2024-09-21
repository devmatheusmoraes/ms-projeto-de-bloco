# Plataforma de Reserva de Hotéis na Nuvem com Kubernetes

## Visão Geral do Sistema

A plataforma de reserva de hotéis é composta por cinco microsserviços principais:

1. **Serviço de Reserva**: Gerencia a criação e consulta de reservas.
2. **Serviço de Disponibilidade**: Verifica a disponibilidade de quartos em hotéis.
3. **Serviço de Notificação**: Envia confirmações e lembretes aos clientes.
4. **Eureka Server**: Gerenciador de serviços que permite que os microsserviços se descubram.
5. **Gateway**: Roteador que direciona as solicitações dos clientes para os serviços apropriados.

## Interligação com Kubernetes

### Pods
No Kubernetes, um **pod** é a menor unidade de implementação. Cada microsserviço do seu sistema será implantado em um pod. Por exemplo, você terá um pod para o **Serviço de Reserva**, outro para o **Serviço de Disponibilidade**, e assim por diante. Cada pod conterá uma ou mais instâncias do seu microsserviço, permitindo que eles sejam escaláveis e independentes.

### Services
Um **service** é uma abstração que define uma forma de acessar um conjunto de pods. No seu projeto, cada microsserviço terá seu próprio service para permitir a comunicação entre eles. Por exemplo:

- O **Serviço de Reserva** terá um service que o conecta ao **Serviço de Disponibilidade**, permitindo que ele consulte a disponibilidade de quartos.
- O **Gateway** atuará como um service que roteia as solicitações externas para os serviços internos apropriados.

### Deployments
Um **deployment** é responsável por gerenciar o ciclo de vida de um pod. Ele garante que um número desejado de réplicas de um pod esteja em execução. Para sua plataforma, você criaria um deployment para cada microsserviço. Por exemplo:

- O **deployment do Serviço de Reserva** garantirá que sempre haja, digamos, três instâncias rodando, o que aumenta a disponibilidade e a capacidade de atendimento a requisições simultâneas.

### Rules (Regras)
As **regras** referem-se à configuração do Ingress, que gerencia o acesso externo aos serviços. No seu caso, você pode definir regras que direcionam o tráfego para os serviços corretos com base em URLs ou parâmetros de consulta. Por exemplo, uma regra pode encaminhar requisições que começam com `/reservas` para o **Serviço de Reserva** e aquelas que começam com `/disponibilidade` para o **Serviço de Disponibilidade**.

## Fluxo de Funcionamento

1. **Solicitação de Reserva**: O cliente envia uma solicitação ao **Gateway**, que usa regras de Ingress para rotear a requisição para o **Serviço de Reserva**.
   
2. **Verificação de Disponibilidade**: O **Serviço de Reserva** consulta o **Serviço de Disponibilidade** (acessando o service correspondente) para verificar se há quartos disponíveis.

3. **Confirmação de Reserva**: Se houver disponibilidade, o **Serviço de Reserva** confirma a reserva e aciona o **Serviço de Notificação** para enviar a confirmação ao cliente.

4. **Atualização de Disponibilidade**: O **Serviço de Disponibilidade** é atualizado com a nova reserva, bloqueando os quartos para as datas solicitadas.

## Conclusão
Implementar a plataforma de reserva de hotéis na nuvem com Kubernetes permite que os microsserviços sejam escaláveis, resilientes e facilmente gerenciáveis. Com pods, services, deployments e regras, garantimos que a aplicação funcione de forma eficiente e atenda às demandas dos clientes.

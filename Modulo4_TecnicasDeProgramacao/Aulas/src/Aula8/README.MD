1. Crie uma classe NOtaFiscal que represente uma nota fiscal com os atributos: número da nota,
valor e data de emissão. Depois, crie uma fila de notas fiscais e adicione algumas notas a essa
fila. Crie também uma classe EnviadorDeNotaFiscal que retire uma nota fiscal da fila e envie-a
para o destinatário (imprima na tela). crie um ScheduledExecutorService e submeta uma instância 
da classe EnviadorDeNotaFiscal para ser executada a cada 10 segundos. Por último, modifiqu a
classe EnviadorDeNotaFiscal para incluir tratamento de exceções, por exemplo, se a fila estiver
vazia ou se ocorrer algum erro ao enviar a nota fiscal.
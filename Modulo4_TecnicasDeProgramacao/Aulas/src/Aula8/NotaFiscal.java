package Aula8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class NotaFiscal{
    private UUID numeroDaNota;
    private BigDecimal valorDaNota;
    private LocalDateTime dataHoraEmissao;

    public NotaFiscal(UUID numeroDaNota, BigDecimal valorDaNota, LocalDateTime dataHoraEmissao){
        this.numeroDaNota = numeroDaNota;
        this.valorDaNota = valorDaNota;
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public UUID getNumeroDaNota() {
        return numeroDaNota;
    }

    public BigDecimal getValorDaNota() {
        return valorDaNota;
    }

    public LocalDateTime getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" +
                "numeroDaNota=" + numeroDaNota +
                ", valorDaNota=" + valorDaNota +
                ", dataHoraEmissao=" + dataHoraEmissao +
                '}';
    }
}

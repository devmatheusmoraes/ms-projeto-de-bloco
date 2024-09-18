package br.com.infnet.hoteis.reserva.model;

import br.com.infnet.hoteis.reserva.dto.AtualizarReserva;
import br.com.infnet.hoteis.reserva.dto.ReservaDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valor;

    private Integer numeroAdultos;

    private Integer numeroCriancas;

    private Integer numeroComodos;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Reserva(ReservaDto dto, Hotel hotel, Usuario usuario){
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
        this.numeroAdultos = dto.numeroAdultos();
        this.numeroCriancas = dto.numeroCriancas();
        this.numeroComodos = dto.numeroComodos();
        this.hotel = hotel;
        this.usuario = usuario;
    }

    public void atualizar(AtualizarReserva dto){
        this.dataInicio = dto.reservaDto().dataInicio();
        this.dataFim = dto.reservaDto().dataFim();
        this.numeroAdultos = dto.reservaDto().numeroAdultos();
        this.numeroCriancas = dto.reservaDto().numeroCriancas();
        this.numeroComodos = dto.reservaDto().numeroComodos();
        this.valor = Objects.nonNull(this.hotel) ? ReservaCalculator.calcularValorReserva(this.hotel) : BigDecimal.ZERO;
    }

}

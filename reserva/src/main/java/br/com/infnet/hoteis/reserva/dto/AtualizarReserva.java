package br.com.infnet.hoteis.reserva.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AtualizarReserva(

        ReservaDto reservaDto,
        @NotBlank
        @Positive
        Long idHotel
) {
}

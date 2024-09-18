package br.com.infnet.hoteis.reserva.service;

import br.com.infnet.hoteis.reserva.model.Hotel;
import br.com.infnet.hoteis.reserva.model.Reserva;
import br.com.infnet.hoteis.reserva.model.Usuario;
import br.com.infnet.hoteis.reserva.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ReservaService {
    private final ReservaRepository reservaRepository;
    public Optional<Reserva> findById(Long id){
        return reservaRepository.findById(id);
    }
    public List<Reserva> findAll(){
        return reservaRepository.findAll();
    }
    public void save(Reserva reserva){
        reservaRepository.save(reserva);
    }
    public void deleteById(Long id){
        reservaRepository.deleteById(id);
    }
    public void atualizar(Reserva reservaAtualizada){
        reservaRepository.save(reservaAtualizada);
    }
}

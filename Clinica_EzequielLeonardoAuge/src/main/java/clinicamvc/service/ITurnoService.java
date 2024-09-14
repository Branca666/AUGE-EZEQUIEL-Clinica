package clinicamvc.service;

import clinicamvc.dto.request.TurnoRequestDTO;
import clinicamvc.dto.response.TurnoResponseDTO;
import clinicamvc.exception.BadRequestException;
import clinicamvc.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    TurnoResponseDTO registrarTurno(TurnoRequestDTO turnoRequestDTO) throws BadRequestException;
    TurnoResponseDTO buscarTurnoPorId(Integer id);
    List<TurnoResponseDTO> buscarTodosTurnos();
    void actualizarTurno(Integer id, TurnoRequestDTO turnoRequestDTO);
    void eliminarTurno(Integer id) throws ResourceNotFoundException;

    // HQL
    List<TurnoResponseDTO> buscarTurnoEntreFechas(LocalDate startDate, LocalDate endDate);
}

package clinicamvc.service;

import clinicamvc.entity.Paciente;
import clinicamvc.exception.BadRequestException;
import clinicamvc.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {


    Paciente registrarPaciente(Paciente paciente) throws BadRequestException;

    Optional<Paciente> buscarPorId(Integer id) throws ResourceNotFoundException;

    List<Paciente> buscarTodos();

    void actualizarPaciente(Paciente paciente) throws ResourceNotFoundException;
    void eliminarPaciente(Integer id) throws ResourceNotFoundException;
}

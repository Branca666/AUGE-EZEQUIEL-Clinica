package clinicamvc.service;

import clinicamvc.entity.Odontologo;
import clinicamvc.exception.BadRequestException;
import clinicamvc.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    Odontologo registrarOdontologo(Odontologo odontologo) throws BadRequestException;

    List<Odontologo> listarOdontologos();

    Optional<Odontologo> buscarOdontologoporID(Integer id) throws ResourceNotFoundException;

    void actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;
    void eliminarOdontologo(Integer id) throws ResourceNotFoundException;

    List<Odontologo> buscarporApellido(String apellido) throws ResourceNotFoundException;

    List<Odontologo> buscarporNombre(String nombre) throws ResourceNotFoundException;

}

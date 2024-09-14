package clinicamvc.controller;

import clinicamvc.dto.request.TurnoRequestDTO;
import clinicamvc.dto.response.TurnoResponseDTO;
import clinicamvc.exception.BadRequestException;
import clinicamvc.exception.ResourceNotFoundException;
import clinicamvc.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<TurnoResponseDTO> agregarTurno(@RequestBody TurnoRequestDTO turno) throws BadRequestException {
        TurnoResponseDTO turnoRegistrado= turnoService.registrarTurno(turno);
            return ResponseEntity.status(HttpStatus.CREATED).body(turnoRegistrado); // Al estar correcto, implementamos el objeto a creaar.
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> buscarTodosTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodosTurnos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTurno (@PathVariable Integer id, @RequestBody TurnoRequestDTO turno){
        turnoService.actualizarTurno(id,turno);
        return ResponseEntity.ok("Turno actualizado");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("{\"message\": \"turno eliminado\"}");
    }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @GetMapping("/fechas")
    public ResponseEntity<List<TurnoResponseDTO>> buscarEntreFechas(@RequestParam String inicio, @RequestParam String fin){
        LocalDate fechaInicio = LocalDate.parse(inicio, formatter);
        LocalDate fechaFinal = LocalDate.parse(fin, formatter);

        return ResponseEntity.ok(turnoService.buscarTurnoEntreFechas(fechaInicio, fechaFinal));
    }
}

package API.notebook.notebook.service;

import API.notebook.notebook.entity.Notebook;
import API.notebook.notebook.repository.INotebooksRepository;
import API.notebook.notebook.service.implementacion.NotebookServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class NotebookServiceTest {

    @Mock
    private INotebooksRepository notebooksRepository;

    @InjectMocks
    private NotebookServiceImpl notebookService;

    private Notebook notebook;

    @BeforeEach
    void setup(){
        notebook = Notebook.builder()
                .id(1L)
                .brand("samsung")
                .model("360")
                .processor("intel i7")
                .ram(16)
                .storage("1tb")
                .gpu("2070")
                .price(1000)
                .build();
    }

    @DisplayName("Test para guardar un empleado")
    @Test
    void testGuardarNotebook(){
        given(notebooksRepository.save(notebook)).willReturn(notebook);

        Notebook notebookGuardada = notebookService.createNotebook(notebook);

        assertThat(notebookGuardada).isNotNull();
    }

    @DisplayName("Test para listar notebooks")
    @Test
    void testListarNotebboks(){

        Notebook notebook1 = Notebook.builder()
                .brand("hp")
                .model("hp")
                .processor("ryzen")
                .ram(8)
                .storage("1tb")
                .gpu("1060")
                .price(1000)
                .build();
        given(notebooksRepository.findAll()).willReturn(List.of(notebook, notebook1));

        List<Notebook> notebooks = notebookService.getAllNotebooks();

        assertThat(notebooks).isNotNull();
        assertThat(notebooks.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener notebook por id")
    @Test
    void testListarNotebookPorID(){
        given(notebooksRepository.findById(1L)).willReturn(Optional.of(notebook));

        Notebook notebookGuardado = notebookService.getNotebookById(notebook.getId());

        assertThat(notebookGuardado).isNotNull();
    }

    @DisplayName("Test para actualizar notebook")
    @Test
    void testActualizarNotebook(){
        given(notebooksRepository.findById(notebook.getId())).willReturn(Optional.of(notebook));
        given(notebooksRepository.save(notebook)).willReturn(notebook);

        notebook.setBrand("acer");

        Notebook notebookActualizada = notebookService.updateNotebook(notebook);

        assertThat(notebookActualizada.getBrand()).isEqualTo("acer");
    }

    @DisplayName("Test para elminar un notebook")
    @Test
    void testEliminarNotebook(){
        long notebookId = 1L;
        willDoNothing().given(notebooksRepository).deleteById(notebookId);

        notebookService.deleteNotebook(notebookId);

        verify(notebooksRepository,times(1)).deleteById(notebookId);
    }

}

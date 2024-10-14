package API.notebook.notebook.repository;
import static org.assertj.core.api.Assertions.assertThat;
import API.notebook.notebook.entity.Notebook;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class NotebookRepositoryTest {

    @Autowired
    private INotebooksRepository notebooksRepository;

    private Notebook notebook;

    @BeforeEach
    void setup(){
        notebook = Notebook.builder()
                .brand("samsung")
                .model("360")
                .processor("intel i7")
                .ram(16)
                .storage("1tb")
                .gpu("2070")
                .price(1000)
                .build();
    }

    @DisplayName("Test para guardar notebook")
    @Test
    void guardarNotebook() {
        // Setup
        Notebook notebook1 = Notebook.builder()
                .brand("sam")
                .model("sam")
                .processor("ryzen")
                .ram(4)
                .storage("1tb")
                .gpu("1060")
                .price(1000)
                .build();
        // Act
        Notebook notebookGuardada = notebooksRepository.save(notebook1);

        // Assert
        assertThat(notebookGuardada).isNotNull();
        assertThat(notebookGuardada.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar notebooks")
    @Test
    void testListarNotebooks(){
        //given
        Notebook notebook1 = Notebook.builder()
                .brand("HP")
                .model("Pavilon")
                .processor("ryzen")
                .ram(8)
                .storage("1tb")
                .gpu("Integrada")
                .price(1000)
                .build();
        notebooksRepository.save(notebook1);
        notebooksRepository.save(notebook);

        //when
        List<Notebook> listaNotebook = notebooksRepository.findAll();

        //then
        assertThat(listaNotebook).isNotNull();
        assertThat(listaNotebook.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener una notebook por ID")
    @Test
    void testObtenerNotebookPorId() {
        notebooksRepository.save(notebook);

        Notebook notebookDB = notebooksRepository.findById(notebook.getId()).get();

        assertThat(notebookDB).isNotNull();
    }

    @DisplayName("Test para actualizar una notebook")
    @Test
    void testActualizarNotebook() {
        notebooksRepository.save(notebook);

        Notebook notebookGuardada = notebooksRepository.findById(notebook.getId()).get();
        notebookGuardada.setBrand("apple");
        Notebook notebookActualizar = notebooksRepository.save(notebookGuardada);
        assertThat(notebookActualizar).isNotNull();
        assertThat(notebookGuardada.getBrand()).isEqualTo("apple");
    }

    @DisplayName("Test para eliminar una notebook")
    @Test
    void testEliminarNotebook(){
        notebooksRepository.save(notebook);

        notebooksRepository.deleteById(notebook.getId());
        Optional<Notebook> notebookOptional = notebooksRepository.findById(notebook.getId());

        assertThat(notebookOptional).isEmpty();

    }
}
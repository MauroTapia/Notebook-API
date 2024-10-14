package API.notebook.notebook.repository;

import API.notebook.notebook.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INotebooksRepository extends JpaRepository<Notebook, Long> {
    Optional<Notebook> findById(Long notebookId);
}

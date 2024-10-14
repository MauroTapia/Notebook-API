package API.notebook.notebook.service.implementacion;

import API.notebook.notebook.entity.Notebook;
import API.notebook.notebook.repository.INotebooksRepository;
import API.notebook.notebook.service.INotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookServiceImpl implements INotebookService {

    @Autowired
    private INotebooksRepository notebooksRepository;

    @Override
    public Notebook createNotebook(Notebook notebook) {
        return notebooksRepository.save(notebook);
    }

    @Override
    public Notebook getNotebookById(Long notebookId) {
        Optional<Notebook> optionalNotebook = notebooksRepository.findById(notebookId);
        return optionalNotebook.orElse(null);
    }

    @Override
    public List<Notebook> getAllNotebooks() {
        return notebooksRepository.findAll();
    }

    @Override
    public Notebook updateNotebook(Notebook notebook) {
        Notebook notebookUpdated = notebooksRepository.findById(notebook.getId()).get();
        notebookUpdated.setBrand(notebook.getBrand());
        notebookUpdated.setModel(notebook.getModel());
        notebookUpdated.setProcessor(notebook.getProcessor());
        notebookUpdated.setRam(notebook.getRam());
        notebookUpdated.setStorage(notebook.getStorage());
        notebookUpdated.setGpu(notebook.getGpu());
        notebookUpdated.setPrice(notebook.getPrice());
        Notebook notebookUpdateSave = notebooksRepository.save(notebookUpdated);
        return notebookUpdateSave;
    }

    @Override
    public void deleteNotebook(Long notebookId) {
        notebooksRepository.deleteById(notebookId);
    }
}

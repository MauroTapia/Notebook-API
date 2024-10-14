package API.notebook.notebook.controller;

import API.notebook.notebook.entity.Notebook;
import API.notebook.notebook.service.implementacion.NotebookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notebook")
public class NotebookController {

    @Autowired
    private NotebookServiceImpl notebookService;

    @GetMapping
    public ResponseEntity<List<Notebook>> getAllNotebooks() {
        List<Notebook> notebooks = notebookService.getAllNotebooks();
        if (notebooks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(notebooks, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Notebook> createNotebook(@RequestBody Notebook notebook) {
        Notebook savedBook = notebookService.createNotebook(notebook);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{notebookId}")
    public ResponseEntity<Notebook> getNotebookById(@PathVariable Long notebookId) {
            Notebook notebook = notebookService.getNotebookById(notebookId);
            return new ResponseEntity<>(notebook, HttpStatus.OK);
    }

    @DeleteMapping("{notebookId}")
    public ResponseEntity<String> deleteNotebookById(@PathVariable Long notebookId) {
        Notebook notebook = notebookService.getNotebookById(notebookId);
        if (notebook != null) {
            notebookService.deleteNotebook(notebookId);
            return new ResponseEntity<>("Notebook deleted", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Notebook not found", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Notebook> updateNotebook(@PathVariable("id") Long notebookId, @RequestBody Notebook notebook) {
        notebook.setId(notebookId);
        Notebook updateNotebook = notebookService.updateNotebook(notebook);
        return new ResponseEntity<>(updateNotebook, HttpStatus.OK);
    }

}

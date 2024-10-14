package API.notebook.notebook.service;


import API.notebook.notebook.entity.Notebook;

import java.util.List;

public interface INotebookService {

    Notebook createNotebook(Notebook notebook);
    Notebook getNotebookById(Long notebookId);
    List<Notebook> getAllNotebooks();
    Notebook updateNotebook(Notebook notebook);
    void deleteNotebook(Long notebookId);
}

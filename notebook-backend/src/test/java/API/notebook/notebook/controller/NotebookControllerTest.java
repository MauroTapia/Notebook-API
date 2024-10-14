package API.notebook.notebook.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



import API.notebook.notebook.entity.Notebook;
import API.notebook.notebook.service.implementacion.NotebookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@WebMvcTest
public class NotebookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotebookServiceImpl notebookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGuardarNotebook() throws Exception {
        //given
        Notebook notebook1 = Notebook.builder()
                .brand("sam")
                .model("sam")
                .processor("ryzen")
                .ram(4)
                .storage("1tb")
                .gpu("1060")
                .price(1000)
                .build();
        given(notebookService.createNotebook(any(Notebook.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(post("/api/notebook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notebook1)));

        //then
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.brand",is(notebook1.getBrand())))
                .andExpect(jsonPath("$.model",is(notebook1.getModel())))
                .andExpect(jsonPath("$.processor",is(notebook1.getProcessor())))
                .andExpect(jsonPath("$.ram",is(notebook1.getRam())))
                .andExpect(jsonPath("$.storage",is(notebook1.getStorage())))
                .andExpect(jsonPath("$.gpu",is(notebook1.getGpu())))
                .andExpect(jsonPath("$.price",is(notebook1.getPrice())));
    }

    @Test
    void testListarNotebooks() throws Exception{
        //given
        List<Notebook> listaNotebooks = new ArrayList<>();
        listaNotebooks.add(Notebook.builder().brand("Dell").model("XPS 13").processor("Intel Core i7-1165G7").ram(16).storage("512GB SSD").gpu("Intel Iris Xe").price(1400).build());
        listaNotebooks.add(Notebook.builder().brand("Apple").model("MacBook Pro 16").processor("M1 Max").ram(32).storage("1TB SSD").gpu("M1 Max GPU").price(3500).build());
        listaNotebooks.add(Notebook.builder().brand("Asus").model("ROG Strix G15").processor("AMD Ryzen 9 5900HX").ram(32).storage("1TB SSD").gpu("NVIDIA GeForce RTX 3080").price(2000).build());
        given(notebookService.getAllNotebooks()).willReturn(listaNotebooks);

        //when
        ResultActions response = mockMvc.perform(get("/api/notebook"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaNotebooks.size())));
    }

    @Test
    void testObtenerNotebookPorId() throws Exception{
        //given
        long notebookID = 1L;
        Notebook notebook1 = Notebook.builder()
                .brand("sam")
                .model("sam")
                .processor("ryzen")
                .ram(4)
                .storage("1tb")
                .gpu("1060")
                .price(1000)
                .build();

        given(notebookService.getNotebookById(notebookID)).willReturn(notebook1);
        //when
        ResultActions response = mockMvc.perform(get("/api/notebook/{id}",notebookID));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand",is(notebook1.getBrand())))
                .andExpect(jsonPath("$.model",is(notebook1.getModel())))
                .andExpect(jsonPath("$.processor",is(notebook1.getProcessor())))
                .andExpect(jsonPath("$.ram",is(notebook1.getRam())))
                .andExpect(jsonPath("$.storage",is(notebook1.getStorage())))
                .andExpect(jsonPath("$.gpu",is(notebook1.getGpu())))
                .andExpect(jsonPath("$.price",is(notebook1.getPrice())));
    }

    @Test
    void testActualizarEmpleado() throws Exception{

        //given
        long notebookID= 1L;

        Notebook notebookGuardado = Notebook.builder()
                .brand("Dell").
                model("XPS 13").
                processor("Intel Core i7-1165G7").
                ram(16).
                storage("512GB SSD").
                gpu("Intel Iris Xe").
                price(1400).
                build();

        Notebook notebookActualizado = Notebook.builder()
                .brand("Apple").
                model("MacBook Pro 16").
                processor("M1 Max").
                ram(32).
                storage("1TB SSD").
                gpu("M1 Max GPU").
                price(3500).
                build();


        given(notebookService.getNotebookById(notebookID)).willReturn(notebookGuardado);
        given(notebookService.updateNotebook(any(Notebook.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(patch("/api/notebook/{id}",notebookID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notebookActualizado)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand",is(notebookActualizado.getBrand())))
                .andExpect(jsonPath("$.model",is(notebookActualizado.getModel())))
                .andExpect(jsonPath("$.processor",is(notebookActualizado.getProcessor())))
                .andExpect(jsonPath("$.ram",is(notebookActualizado.getRam())))
                .andExpect(jsonPath("$.storage",is(notebookActualizado.getStorage())))
                .andExpect(jsonPath("$.gpu",is(notebookActualizado.getGpu())))
                .andExpect(jsonPath("$.price",is(notebookActualizado.getPrice())));
    }

    @Test
    void testEliminarNotebook() throws Exception{
        //given
        long notebookID = 1L;
        willDoNothing().given(notebookService).deleteNotebook(notebookID);

        //when
        ResultActions response = mockMvc.perform(delete("/api/notebook/{id}",notebookID));

        //then
        response.andExpect(status().isOk())
                .andDo(print());
    }

}

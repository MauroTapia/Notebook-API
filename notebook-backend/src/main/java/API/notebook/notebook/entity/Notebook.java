package API.notebook.notebook.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "\"Notebook\"", schema = "public")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "brand", nullable = false)
    private String brand;       // Marca (ej: Dell, HP)
    @Column(name = "model", nullable = false)
    private String model;       // Modelo (ej: Inspiron 15)
    @Column(name = "processor", nullable = false)
    private String processor;   // Procesador (ej: Intel i5)
    @Column(name = "ram", nullable = false)
    private int ram;            // Memoria RAM (en GB)
    @Column(name = "storage", nullable = false)
    private String storage;        // Almacenamiento (en GB)
    @Column(name = "gpu", nullable = false)
    private String gpu;         // Tarjeta gráfica (si tiene)
    @Column(name = "price", nullable = false)
    private double price;



}

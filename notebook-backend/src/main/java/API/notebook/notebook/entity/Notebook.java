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
    private String brand;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "processor", nullable = false)
    private String processor;
    @Column(name = "ram", nullable = false)
    private int ram;
    @Column(name = "storage", nullable = false)
    private String storage;
    @Column(name = "gpu", nullable = false)
    private String gpu;
    @Column(name = "price", nullable = false)
    private double price;



}

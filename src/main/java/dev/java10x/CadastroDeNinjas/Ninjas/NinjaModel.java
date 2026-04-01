package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missao")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    @Column(unique = true)
    private String email;
    @Column(name = "url_image")
    private String imageUrl;
    private String rank;
    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;
}

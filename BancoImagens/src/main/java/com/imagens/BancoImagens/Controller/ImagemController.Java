package com.imagens.BancoImagens.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.imagens.BancoImagens.Model.ImagemModel;
import com.imagens.BancoImagens.Service.ImagemService;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/imagens")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    @PostMapping // Adiciona uma nova imagem
    public ImagemModel adicionarImagem(@RequestBody ImagemModel imagem) {
        return imagemService.salvarImagem(imagem);
    }
    @GetMapping//{id} // Busca uma imagem pelo ID
    public List<ImagemModel> listarImagens() {
        return imagemService.listarImagens(); 
    }
    @DeleteMapping("/{id}")// Deleta uma imagem pelo ID
    public ImagemModel deletarImagem(@PathVariable Long id) {
     imagemService.deletarImagem(id);
    }
    @PutMapping("/{id}") // Atualiza uma imagem pelo ID
    public ImagemModel atualizarImagem(@PathVariable Long id, @RequestBody ImagemModel novaImagem) {
        return imagemService.atualizarImagem(id, novaImagem);
    }
}

package br.ufc.web._final.controller;

import br.ufc.web._final.model.Cliente;
import br.ufc.web._final.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("cliente/cadastrar_cliente");
        mv.addObject("cliente", new Cliente());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(Cliente cliente) {
        clienteService.save(cliente);
        ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
        return mv;
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        List<Cliente> listaClientes = clienteService.listClientes();
        ModelAndView mv = new ModelAndView("cliente/listar_clientes");
        mv.addObject("listaClientes", listaClientes);

        return mv;
    }

    @RequestMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        clienteService.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
        return mv;
    }

    @RequestMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable Long id) {
        Cliente cliente = clienteService.serchById(id);
        ModelAndView mv = new ModelAndView("cliente/cadastrar_cliente");
        mv.addObject("cliente", cliente);
        return mv;
    }

}
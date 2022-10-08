// Jeova Caçula de Aguiar Júnior
// Universidade Federal do Ceará - campus Crateús
// Ciência da Computacação

const { query } = require('express');
const express = require('express')
const app = express()
const port = 3000

app.use(express.static('public'));
app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.set('view engine', 'ejs');
app.set('views', './views');

app.get('/produtos', (req, res) => {

  var i=0
  array.forEach(function(obj) {
    if(produtos.categoria == obj.chave) return
    i = ++i
  });

  res.render('produtos',{title: 'Produtos', cat: array, aProdutos: produtos, i: i})

});

app.get('/categorias', (req, res) => {
  res.render('categorias', {title: 'Categorias', a: array})
});

app.get('/categoria-deletar',(req, res)=>{
  let key = req.query.chave;

  for (let i = 0; i < array.length; i++) {
    if(array[i].chave == key){
      array.splice(i, 1);
    }
  }

  res.redirect('categorias')
});

app.get('/home', (req, res) => {
  res.render('home', {title: 'Lab MPA', message: 'Bem vindo ao Lab MPA'});
});

app.post('/categoria-salvar',(req, res)=>{
  array.push(req.body)
  console.log(array)

  res.redirect('categorias')
});

array = 
[
  {chave: "32", valor: "PORSCHE"},
  {chave: "33", valor: "LAMBORGHINI"},
  {chave: "34", valor: "MASERATI"},
  {chave: "45", valor: "FERRARI"}
]

//pratica05
//var idProduto = 1;
produtos = [
  //{id: 1, nome: "Casa", descricao: "Casa linda com gramado verde sintilante e vista para o mar.", preco: 12.00}
]

app.get('/cadastrar-produto', (req, res) => {
  let idProd = 0;
  if(produtos.length == 0) {
    idProd = 1
  }else{
    idProd = parseInt(produtos[produtos.length-1].id);
    ++idProd;
  }

  res.render('cadastrar-produto', {title: 'Cadastrar produto', aCategorias: array, idProduto: idProd});
});

app.post('/cadastrar-produto', (req, res) => {

  console.log(req.body)
  produtos.push(req.body)
  console.log(produtos)

  res.redirect('produtos');
});

app.get('/produto-editar', (req, res) => {
  console.log(req.query.id)

  produtos.forEach(element => {
    if(element.id == req.query.id) produto = element
  });

  //let idProd = parsiInt(produto.id)

  //res.redirect('produtos')
  res.render('produto-editar', {title: 'Editar produto', aCategorias: array, tId: produto.id, tNome: produto.nome, tDescricao: produto.descricao, tPreco: produto.preco})
});

app.post('/produto-editar', (req, res) => {
  console.log(req.body)

 produtos.forEach(element => {
    if(element.id == req.body.id){
      element.categoria = req.body.categoria
      element.nome = req.body.nome
      element.descricao = req.body.descricao
      element.preco = req.body.preco
    }
  });

  res.redirect('produtos');
});


// ===============================================
// Construido na pratica anterior

animals = [
  {animal: "DOG", name:"Pluto"}
  ,{animal:"CAT", name:"Hercules"}
  ,{animal:"BIRD", name:"Tweety"}
  ,{animal:"DOG", name:"Spiff"}
  ,{animal:"CAT", name:"Tom"}
  ,{animal:"BIRD", name:"Road Runner"}
]

//Busca animal pelo nome ou pelo tipo
app.get('/animal', (req, res) => {
  if(req.query.name){
    busca = req.query.name
    respArray = []
    for (let i = 0; i < animals.length; i++) {
      const a = animals[i];
      if(a.name.includes(busca)){
        respArray.push(a)        
      }
    }
    res.send(respArray);
  }else if(req.query.animal){
    busca = req.query.animal
    respArray = []
    for (let i = 0; i < animals.length; i++) {
      const a = animals[i];
      if(a.animal.includes(busca)){
        respArray.push(a)        
      }
    }
    res.send(respArray);

  } else {
    res.send(animals);
  }
})

//retorna os dados enviados pelo post para a rota mirror
app.post('/mirror', function (req, res) {
  console.log(req.body)
  res.send(req.body)
})

// Retorna o nosso array
app.get('/animals', (req, res) => {
    console.log(animals);
  res.send(animals)
})

// Mostra no console a porta que está rodando a aplicação
app.listen(port, () => {
  console.log(`--`)
  console.log(`=========== Nossa aplicação está rodando na porta ${port} ===========`)
  console.log(`--`)
})

// Busca pelos parâmetros da consulta
app.get('/paramtojson/name/:name/role/:role', (req, res) => {
  console.log(req.params);
  res.send(req.params);
})  

// Busca pelo caminho
app.get('/querytojson', (req, res) => {
  console.log(req.query);
res.send(req.query)
})

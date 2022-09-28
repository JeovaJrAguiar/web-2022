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
  res.render('produtos',{title: 'Produtos'})
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
  {chave: "32", valor: "23.00"},
  {chave: "33", valor: "33.00"},
  {chave: "34", valor: "43.00"},
  {chave: "45", valor: "45.00"}
]

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

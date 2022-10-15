// Jeova Caçula de Aguiar Júnior
// Universidade Federal do Ceará - campus Crateús
// Ciência da Computacação

const { query } = require('express');
const express = require('express')
const app = express()
const port = 3000

const basicAuth = require('express-basic-auth');

/*app.use(basicAuth({
  users: { 'admin': '12345' },
  challenge: true
}));*/

/*app.use('/produto/*', basicAuth( { authorizer: myAuthorizerMongo, authorizeAsync: true , challenge: true} ));

function myAuthorizerMongo(username, password, cb) {
  console.log(username)
  console.log(password)

    console.log(
      database.getUsers(username, password)
        .then(users => {
          return cb(null, users.length > 0);
    }));
}*/
// ===============================================
// create mongo client
const { MongoClient } = require('mongodb');

// Connection URL
const url = 'mongodb://root:rootpwd@localhost:27017';
const client = new MongoClient(url);

// Database Name
const dbName = 'ufcwebauth';
var db;
var user_collection;
async function main() {
  await client.connect();
  console.log('Connected successfully to server');
  db = client.db(dbName);
  console.log(db);
  user_collection = db.collection('user');
  console.log(user_collection);
  return 'done.';
}

main()
  .then(console.log)
  .catch(console.error);
//   .finally(() => client.close());
app.use(basicAuth( { authorizer: myAsyncAuthorizer } ))

function myAsyncAuthorizer(username, password, cb) {
  getUsers(username, password)
    .then(users => {
          return cb(null, users.length > 0);
  })
}
async function getUsers(username, password) {
  console.log("in getUsers")
  console.log(username, password)

    const findResult = await db.user_collection.find({username: username, password: password}).toArray();
    console.log('Found documents =>', findResult);
    return findResult;
}

exports.getUsers = getUsers;
// ===========================

app.use(express.static('public'));
app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.set('view engine', 'ejs');
app.set('views', './views');

array =
[
  {chave: "32", valor: "Carro"},
  {chave: "33", valor: "Livro", },
  {chave: "34", valor: "Mesa"},
  {chave: "45", valor: "Faca"}
]

camposCustomizados = [
  {
    chaveCategoria: "32",
    campos: [
      {valor: "roda"},
      {valor: "porta"},
      {valor: "farol"},
      {valor: "banco"}
    ]
  }
]

app.get('/produtos', (req, res) => {
  var j=0
  var i=0
  array.forEach(function(obj) {
    if(produtos.categoria == obj.chave) return
    i = ++i
  });
  //<%= if(obj.categoria == cat.valor) j++%>

  res.render('produtos',{title: 'Produtos', aCat: array, aProdutos: produtos, i: i, j: j})
});

app.get('/categorias', (req, res) => {
  res.render('categorias', {title: 'Categorias', a: array, cCustomizados: camposCustomizados})
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

app.get('/', (req, res) => {
  basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
  username = basic[0];
  password = basic[1];
  console.log('Username: ' + username);
  console.log('Password: ' + password);

  //res.render('home', {title: 'Lab MPA', message: 'Bem vindo ao Lab MPA'});
});

app.post('/categoria-salvar',(req, res)=>{
  array.push(req.body)
  console.log(array)

  res.redirect('categorias')
});

//pratica05
//var idProduto = 1;
produtos = [
  //{id: 1, nome: "Casa", categoria: "", descricao: "Casa linda com gramado verde sintilante e vista para o mar.", preco: 12.00}
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
// server
app.listen(port, () => {
  console.log(`--`)
  console.log(`=========== Nossa aplicação está rodando na porta ${port} ===========`)
  console.log(`--`)
})

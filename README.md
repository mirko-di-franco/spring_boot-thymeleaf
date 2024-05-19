# Thymeleaf

### Differenze Chiave:
- `@RestController`: Utilizzata per creare servizi RESTful. Restituisce direttamente il corpo della risposta (JSON, XML, ecc.) invece del nome di una vista.
- `@Controller`: Utilizzata per restituire viste. Il metodo restituisce il nome della vista, che viene risolto da un ViewResolver per trovare il template HTML.

---
- Il `Model` è un'interfaccia di Spring Framework che viene utilizzata per passare dati dal controller alla vista.
- `model.addAttribute("nome", valore)`: Un metodo che aggiunge un attributo al modello con il nome specificato ("nome") e il valore (valore). Questo rende il dato disponibile nella vista, dove può essere utilizzato per la visualizzazione.
- `@Valid` è un'annotazione di Spring utilizzata per abilitare la validazione automatica degli oggetti. Quando viene applicata a un parametro di un metodo del controller, Spring verifica automaticamente che l'oggetto soddisfi le regole di validazione definite nelle annotazioni del modello.
- `@ModelAttribute` è un'annotazione di Spring che indica che un parametro di metodo o un metodo stesso dovrebbe essere trattato come un attributo del modello. Quando applicata a un parametro di metodo, @ModelAttribute dice a Spring di recuperare o creare un'istanza dell'oggetto e di popolarla con i dati dei parametri della richiesta (come parametri di query o dati del form).
- `BindingResult` è un'interfaccia di Spring utilizzata per mantenere i risultati della validazione e del binding degli oggetti. Viene utilizzata per verificare se ci sono errori nella validazione degli oggetti annotati con @Valid. BindingResult deve sempre seguire immediatamente l'oggetto annotato con @Valid nel parametro del metodo.

**In sintesi, `@Valid` è usato per attivare la validazione, `@ModelAttribute` per legare i dati della richiesta al modello, e `BindingResult` per catturare e gestire gli errori di validazione**.

---

### Annotazioni di Validazione Comuni in Spring
- `@NotNull`: Il campo non può essere null.
- `@Size`: Specifica i limiti di dimensione per stringhe, raccolte, mappe e array.
- `@Min` e `@Max`: Specificano i valori minimo e massimo per un numero.
- `@Email`: Verifica che il campo contenga un indirizzo email valido.
- `@Pattern`: Verifica che il campo corrisponda a una regex specificata.

---

### Form HTML
- `th:field`: Associa un campo del form HTML a una proprietà di un oggetto nel modello.
- `th:if`: Esegue il rendering condizionale di un elemento HTML.
- `th:errorClass`: Aggiunge una classe CSS a un elemento HTML quando ci sono errori di validazione.
- `th:errors`: Visualizza i messaggi di errore di validazione associati a un campo specifico.

---

### Altro
-  `th:text`: Usato per sostituire il contenuto di un elemento con il testo fornito.
-  `th:if / th:unless`: Utilizzati per condizionare la visualizzazione di un elemento in base a una condizione booleana.
-  `th:each`: Permette di iterare su una collezione, generando un elemento per ciascun elemento della collezione.
-  `th:object / th:field`: Usati per i form di input, th:object definisce l'oggetto di binding e th:field lega i campi dell'oggetto ai campi del form.
  
```
ES:
<form th:object="${prodotto}">
      <input type="text" th:field="*{nome}">
      <input type="number" th:field="*{prezzo}">
</form>
```

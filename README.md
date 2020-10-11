# What's in the box?
## Lesson's learned from our domain testing approach

### API
The two main type of classes in the API are `UseCase` and `Repository` classes. The other classes present are used
by the `UseCase` and `Repository` classes to create type-safety in their usage.

#### UseCase
A `UseCase` allows the caller to change the domain. This could be creating a new object, or updating or
removing an existing one. Every `UseCase` contains exactly one method, called `execute` and expects 1 or 2
parameters.

Examples are the `CreateProductUseCase` and the `UpdateProductNameUseCase`.

#### Repository
A `Repository` exists to fetch data from the domain. None of the exposed methods will alter the data.

An example is the `ProductRepository`.

#### Other
The other classes support the `UseCase` and `Repository`. These can be Requests, Identifiers, Filters, and wrappers
to encapsulate requirements.

### Package `utility`
The `utility` package in the domain contains some helper classes. Ideally, these reusable bits of code come from
an external dependency, rather than existing inside the domain.

### Tests
Tests are ran against the UseCase & Repository interfaces.

The @BeforeEach setup() method in each test mimics the injection of the actual classes by instantiating them. Any further
interaction will be done purely through the API class.

#### Mothers
To support the setup of tests, there are `Mother` objects that can be used to create the domain data required for a test.

An example of this is the `ProductMother`.

#### Ugly
If a test uses a domain's internals directly, the name of that test is prefixed with 'Ugly'. This is to clearly
indicate that this type of test violates the testing approach and urges the developer to reconsider the solution and
refactor, or challenge the functional requirement.

An example of this is the `UglyCreateCustomerUseCaseTest`.

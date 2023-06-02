# RMApiSearchCLI

A simple CLI to search a Rick&Morty character by name, status, species, type or gender.

---

## Description

The CLI uses [The Rick and Morty API](https://rickandmortyapi.com/) to request data.

To use the CLI:
```
.\rm-api-search-cli <CHARACTER> [OPTIONS]
```

Where `[OPTIONS]` are:
```
--status <STATUS>    # <STATUS>: alive, dead or unknown. Also available as: -s
--species <SPECIES>  # <SPECIES>: filter by the given species.
--type <TYPE>        # <TYPE>: filter by the given type.
--gender <GENDER>    # <GENDER>: female, male, genderless or unknown. Also available as: -g
```

And `<CHARACTER>` is the name of a Rick&Morty character.

### Example
To search `female` characters named `rick` and `alive`, use: `.\rm-api-search-cli rick -s alive -g female`
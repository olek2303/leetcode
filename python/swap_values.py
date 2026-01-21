import pandas as pd

def swap_salary(salary: pd.DataFrame) -> pd.DataFrame:
    mappings = {
        'f': 'm',
        'm': 'f'
    }

    salary['sex'] = salary['sex'].replace(mappings)

    return salary
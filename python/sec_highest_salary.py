import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)
    if len(salaries) > 1:
        return pd.DataFrame({'SecondHighestSalary': [salaries.iloc[1]]})
    return pd.DataFrame({'SecondHighestSalary': [None]})
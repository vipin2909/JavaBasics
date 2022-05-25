import React from 'react';
import { Divider, FormControlLabel, Checkbox, RadioGroup, Radio } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import { ReducersState } from '../../redux/rootReducer';
import {
  getAttentionPointsTranslation,
  getLocationsTranslation,
} from '../../screens/Admin/ProductSettings/MasterDataTranslation/services';
import ActionName from '../../constants/actionNames';
import styles from './styles';

export default function ProductSettingsFilter(props: any) {
  const classes = styles();
  const dispatch = useDispatch();

  const {
    statusAll,
    language1Filter,
    language2Filter,
    language1: firstLang,
    language2: secondLang,
  } = useSelector((state: ReducersState) => state.MasterDataTranslationReducer);

  const updateList = () => {
    const { masterDataSelected } = props;
    if (masterDataSelected) {
      if (masterDataSelected === 1) {
        dispatch(getAttentionPointsTranslation());
      } else {
        dispatch(getLocationsTranslation());
      }
    }
  };

  const onChangeStatusAll = (event: any) => {
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        statusAll: +event.target.value,
      },
    });
    updateList();
  };

  const onChangeLanguage = (event: any, language: any) => {
    const { target } = event;
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        [language]: target.checked,
      },
    });
    updateList();
  };

  return (
    <div className={classes.mainContainer}>
      <div className={classes.title}>Filter by</div>
      <Divider />
      <div>
        <div className={classes.subTitle}>String translate status</div>
        <div className={classes.filtersBox}>
          <RadioGroup
            id="status"
            value={statusAll}
            onChange={(event: any) => onChangeStatusAll(event)}
          >
            <FormControlLabel value={1} control={<Radio color="primary" />} label="All" />{' '}
            <FormControlLabel
              value={2}
              control={<Radio color="primary" />}
              label="Translated Strings"
            />
            <FormControlLabel
              value={3}
              control={<Radio color="primary" />}
              label="Untranslated Strings"
            />
          </RadioGroup>
        </div>
      </div>
      <Divider />

      <div>
        <div className={classes.subTitle}>Language</div>
        <div className={classes.filtersBox}>
          <FormControlLabel
            value="false"
            checked={language1Filter}
            control={
              <Checkbox
                color="primary"
                name="shift"
                onChange={(event: any) => onChangeLanguage(event, 'language1Filter')}
              />
            }
            label={firstLang}
          />
          <FormControlLabel
            value="true"
            control={
              <Checkbox
                color="primary"
                name="shift"
                checked={language2Filter}
                onChange={(event: any) => onChangeLanguage(event, 'language2Filter')}
              />
            }
            label={secondLang}
          />
        </div>
      </div>
    </div>
  );
}